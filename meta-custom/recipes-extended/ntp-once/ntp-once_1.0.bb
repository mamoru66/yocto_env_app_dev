SUMMARY = "One-time NTP sync service for system startup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PV = "1.0"
SRC_URI = "file://ntp-once.service"
FILES_${PN} = "/etc/systemd/system/ntp-once.service /etc/systemd/system /etc/systemd /etc"
SYSTEMD_SERVICE_${PN} = "ntp-once.service"
do_install() {
    install -d ${D}${sysconfdir}/systemd/system
    install -m 0644 ${WORKDIR}/ntp-once.service ${D}${sysconfdir}/systemd/system/ntp-once.service
}
