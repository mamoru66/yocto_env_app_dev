SUMMARY = "Auto Setup for yfinance environment"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://setup-python-env.sh \
    file://python-env-setup.service \
"

inherit systemd

SYSTEMD_SERVICE:${PN} = "python-env-setup.service"

do_install() {
    # スクリプトを /usr/bin へ
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/setup-python-env.sh ${D}${bindir}

    # サービスファイルを systemd ディレクトリへ
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/python-env-setup.service ${D}${systemd_system_unitdir}
}