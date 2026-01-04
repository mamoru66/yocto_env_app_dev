SUMMARY = "Simple test kernel module"
SECTION = "kernel/modules"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
inherit module

SRC_URI = "file://test-module.c \
           file://Makefile"

S = "${WORKDIR}"

KERNEL_SRC = "${STAGING_KERNEL_DIR}"

EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR}"

do_install() {
    install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0755 ${B}/test-module.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}

FILES_${PN} = "${base_libdir}/modules/"
