SUMMARY = "Static configuration for /etc/resolv.conf"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PV = "1.0"
SRC_URI = "file://resolv.conf"
RDEPENDS_${PN} = ""

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/resolv.conf ${D}${sysconfdir}/resolv.conf
}