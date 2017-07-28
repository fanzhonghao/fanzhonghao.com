#!/bin/bash

echo "---------Begin-----------"
git add .
git commit -m $1
git push -u origin master
echo "---------End-------------"
