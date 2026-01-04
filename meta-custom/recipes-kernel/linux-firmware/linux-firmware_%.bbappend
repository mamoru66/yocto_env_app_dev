FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# 必要なファームウェアファイルを追加
SRC_URI:append = " \
 file://brcmfmac43455-sdio.raspberrypi,4-model-b.bin \
 file://brcmfmac43455-sdio.raspberrypi,4-model-b.txt \
"

do_install:append() {
    BRCM_DIR="${D}/lib/firmware/brcm"

    # 汎用ファームウェアとNVRAM設定が存在する場合、デバイス固有の名前にリンクする
    if [ -f ${BRCM_DIR}/brcmfmac43455-sdio.bin ]; then
        ln -sf brcmfmac43455-sdio.bin ${BRCM_DIR}/brcmfmac43455-sdio.raspberrypi,4-model-b.bin
    fi

    if [ -f ${BRCM_DIR}/brcmfmac43455-sdio.txt ]; then
        ln -sf brcmfmac43455-sdio.txt ${BRCM_DIR}/brcmfmac43455-sdio.raspberrypi,4-model-b.txt
    fi

    install -d ${D}/lib/firmware/brcm
    install -m 0644 ${WORKDIR}/brcmfmac43455-sdio.raspberrypi,4-model-b.bin ${D}/lib/firmware/brcm/
    install -m 0644 ${WORKDIR}/brcmfmac43455-sdio.raspberrypi,4-model-b.txt ${D}/lib/firmware/brcm/
}