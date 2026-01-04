# ファイル検索パスの設定（既存）
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://20-wlan0.network \
    file://30-eth0.network \
    file://rpi-modules.conf \
"

do_install:append() {
    # 既存のnetworkファイルインストール処理（省略）
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/20-wlan0.network ${D}${sysconfdir}/systemd/network/20-wlan0.network
    install -m 0644 ${WORKDIR}/30-eth0.network ${D}${sysconfdir}/systemd/network/30-eth0.network
    install -d ${D}${sysconfdir}/modules-load.d
    install -m 0644 ${WORKDIR}/rpi-modules.conf ${D}${sysconfdir}/modules-load.d/
    echo "NTP=ntp.nict.jp" >> ${D}${sysconfdir}/systemd/timesyncd.conf
    echo "FallbackNTP=pool.ntp.org" >> ${D}${sysconfdir}/systemd/timesyncd.conf
}