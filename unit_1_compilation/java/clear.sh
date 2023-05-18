#!/usr/bin/env sh

find . -type f -name "*.class" -print0 | xargs -0 /bin/rm -f
