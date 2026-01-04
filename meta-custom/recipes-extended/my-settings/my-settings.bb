SUMMARY = "Custom initialization and module loading settings"
LICENSE = "MIT"

# ライセンスファイルのチェックサムを設定
# ここでは、レシピファイル自体にライセンス情報が含まれていると定義します
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# ... (その他の設定や do_install などが続く)

SRC_URI = " \
    file://rpi-init.service \
"

inherit systemd

# ターゲットへのインストール設定
SYSTEMD_SERVICE:${PN} = "rpi-init.service"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/rpi-init.service ${D}${systemd_system_unitdir}
}
