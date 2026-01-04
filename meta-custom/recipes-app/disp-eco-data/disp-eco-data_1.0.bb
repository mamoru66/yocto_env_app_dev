SUMMARY = "A data display application for disp-eco-data"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r2"

CFLAGS  += "-Wall"
LDFLAGS =+ "-Wl,--hash-style=gnu"
EXTRA_OEMAKE = "LDFLAGS='-Wl,--hash-style=gnu'"

S = "${WORKDIR}"

inherit systemd pkgconfig

RDEPENDS:${PN} += " \
    python3-pytz \
    python3-lxml \
"

DEPENDS += "libgpiod"

SRC_URI = "file://disp-eco-data.py \
           file://aqm0802.c \
           file://Makefile \
           file://run_disp_eco_data.sh \
           file://disp-eco-data.service \
           "

SYSTEMD_SERVICE:${PN} = "disp-eco-data.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    # 1. ターゲットディレクトリの作成
    install -d ${D}${bindir}
    install -d ${D}${systemd_system_unitdir}

    # 2. ファイルを一つずつコピー（コピー先もファイル名まで書くのが最も安全）
    install -m 0755 ${S}/aqm0802 ${D}${bindir}/aqm0802
    install -m 0755 ${S}/disp-eco-data.py ${D}${bindir}/disp-eco-data.py
    install -m 0755 ${S}/run_disp_eco_data.sh ${D}${bindir}/run_disp_eco_data.sh
    
    # 3. サービスファイルのコピー
    install -m 0644 ${S}/disp-eco-data.service ${D}${systemd_unitdir}/system/disp-eco-data.service
}

FILES:${PN} += " \
    ${bindir}/* \
    ${systemd_unitdir}/system/* \
    "