SUMMARY = "A small, expressive ORM -- supports postgresql, mysql and sqlite"
HOMEPAGE = "http://github.com/coleifer/peewee/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8a68e3ec7a6e09a43370f0a3fbc48660"

inherit pypi setuptools3

SRC_URI[sha256sum] = "e009ac4227c4fdc0058a56e822ad5987684f0a1fbb20fed577200785102581c3"

RDEPENDS:${PN} += " \
    python3-core \
    python3-datetime \
    python3-logging \
    python3-sqlite3 \
"