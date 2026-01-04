SUMMARY = "Static configuration for /etc/ntp.conf"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
# automake-native への依存は保持
DEPENDS += "automake-native"
# 1. do_configure を完全に上書きするのではなく、前処理として追加する（prepend）
#    これにより、Autotools クラスの正しい do_configure 処理が実行される
do_configure:prepend() {
    # run-strtolfp.c の問題回避とエラー無視 (exit code 1 でタスクが中断するのを防ぐ)
    mkdir -p ${S}/tests/libntp/
    touch ${S}/tests/libntp/run-strtolfp.c || true
}
do_configure:append() {
    touch ${S}/aclocal.m4 || true
}
# 2. カスタム設定ファイルのインストール
do_install:append() {
    install -m 0644 ${WORKDIR}/ntp.conf ${D}${sysconfdir}/ntp.conf
}