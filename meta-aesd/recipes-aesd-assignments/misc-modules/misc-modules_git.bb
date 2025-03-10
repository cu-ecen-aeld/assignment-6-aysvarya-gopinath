# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f098732a73b5f6f3430472f5b094ffdb"

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignment-7-aysvarya-gopinath.git;protocol=ssh;branch=main \
           files://misc-modules-init \
           "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "5c3cae6ddc96b8645dfa6f6bc4ddbba08aae8789"

S = "${WORKDIR}/git"

inherit module update-rc.d
MODULES_INSTALL_TARGET = "install"
EXTRA_OEMAKE += " -C ${STAGING_KERNEL_DIR} M=${S}/misc-modules"

INITSCRIPT_NAME = "misc-modules-init"
INITSCRIPT_PARAMS = "defaults 99"
do_install:append() {
  	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/misc-modules-init ${D}${sysconfdir}/init.d/
}




