# Makefile
# This Makefile uses Yocto's environment variables for compilation

CC ?= ${CC}
CFLAGS ?= ${CFLAGS}

# Target to build the aqm0802 executable
aqm0802: aqm0802.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o aqm0802 aqm0802.c -lgpiod

# Standard clean rule
.PHONY: clean
clean:
	rm -f aqm0802