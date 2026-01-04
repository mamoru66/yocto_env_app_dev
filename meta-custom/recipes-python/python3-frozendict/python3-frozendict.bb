SUMMARY = "An immutable dictionary."
HOMEPAGE = "https://github.com/dgrtwo/frozendict"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

PV = "2.3.4"
SRC_URI = "https://files.pythonhosted.org/packages/source/f/frozendict/frozendict-2.3.4.tar.gz"
SRC_URI[sha256sum] = "15b4b18346259392b0d27598f240e9390fafbff882137a9c48a1e0104fb17f78"

inherit pypi setuptools3

# 依存関係があれば、RDEPENDSに追加
RDEPENDS:${PN} += ""