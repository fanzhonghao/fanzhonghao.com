#!/bin/bash

echo "---------Begin-----------"
git add $1
git commit -m $1
git push -u origin master
echo "---------End-------------"
