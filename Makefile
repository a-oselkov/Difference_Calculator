.DEFAULT_GOAL := build-run

run-dist:
	make -C app run-dist
	
install:
	make -C app install

build:
	make -C app build

run:
	make -C app run

clean:
	make -C app clean

test:
	make -C app test


build-run: build run

.PHONY: build
