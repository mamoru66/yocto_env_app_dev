SUMMARY = "A Python module for determining appropriate platform-specific directories"
HOMEPAGE = "https://github.com/platformdirs/platformdirs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ea4f5a41454746a9ed111e3d8723d17a"
inherit pypi setuptools3

SRC_URI[sha256sum] = "e1fea1fe471b9ff8332e229df3cb7de4f53eeea4998d3b6bfff542115e998bd2"

# 実行時の依存関係
RDEPENDS:${PN} += "python3-modules"

# 【追加】setup.py が無い場合に備えて、ビルド直前にダミーの setup.py を作成する
do_compile:prepend() {
    if [ ! -e ${S}/setup.py ]; then
        cat > ${S}/setup.py <<EOF
from setuptools import setup, find_packages
setup(
    name="platformdirs",
    version="2.6.2",
    packages=find_packages(),
)
EOF
    fi
}