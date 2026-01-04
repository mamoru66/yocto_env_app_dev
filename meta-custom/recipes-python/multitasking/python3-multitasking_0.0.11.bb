SUMMARY = "A simple utility for threading and multiprocessing."
HOMEPAGE = "https://github.com/ranaroussi/multitasking"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "4d6bc3cc65f9b2dca72fb5a787850a88dae8f620c2b36ae9b55248e51bcd6026"

# PyPIのパッケージ名とバージョンに合わせる
PN = "python3-multitasking"
PV = "0.0.11"