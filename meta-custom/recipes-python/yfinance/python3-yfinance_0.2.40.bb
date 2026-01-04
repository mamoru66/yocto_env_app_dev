SUMMARY = "Download market data from Yahoo! Finance API"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"
inherit pypi setuptools3

SRC_URI[sha256sum] = "b053ac31229b5dc7f49a17a057f66aa7f688de2f5ddeb95c2455ec13cd89511a"

RDEPENDS:${PN} += " \
    python3-requests \
    python3-pandas \
    python3-numpy \
    python3-multitasking \
    python3-lxml \
    python3-platformdirs \
    python3-frozendict \
    python3-peewee \
    python3-beautifulsoup4 \
    python3-html5lib \
    python3-appdirs \
"
