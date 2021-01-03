#!/bin/sh
gpg --quiet --batch --yes --decrypt --passphrase="$KEYSTORE_PASSPHRASE" --output "keystore/debug.keystore.jks" "keystore/debug.keystore.jks.gpg"
[ $? -eq 0 ] || exit 1
gpg --quiet --batch --yes --decrypt --passphrase="$PROPERTIES_PASSPHRASE" --output "keystore/keystore.properties" "keystore/keystore.properties.gpg"
[ $? -eq 0 ] || exit 1