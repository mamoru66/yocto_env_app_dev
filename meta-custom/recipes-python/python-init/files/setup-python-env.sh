#!/bin/sh
# 初回起動フラグファイルの確認
FLAG_FILE="/etc/.python_env_setup_done"

if [ ! -f "$FLAG_FILE" ]; then
    echo "Starting initial Python environment setup..."
    
    # ネットワークが繋がるまで待機（最大30秒）
    for i in $(seq 1 30); do
        if ping -c 1 8.8.8.8 > /dev/null 2>&1; then
            break
        fi
        sleep 1
    done

    # 必要なライブラリを特定のバージョンでインストール
    # 壊れた残骸を消してから入れる
    rm -rf /usr/lib/python3.10/site-packages/curl_cffi*
    pip3 install --no-cache-dir curl_cffi==0.13.0 yfinance

    # 成功したらフラグを作成
    if [ $? -eq 0 ]; then
        touch "$FLAG_FILE"
        echo "Python environment setup completed successfully."
        # メインのサービスを再起動して反映させる
        systemctl restart disp-eco-data.service
    else
        echo "Setup failed. Will retry on next boot."
    fi
fi