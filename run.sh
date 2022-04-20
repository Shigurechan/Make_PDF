#!/bin/bash

clear
javac -verbose -cp lib/pdfbox.jar:lib/commons.jar: src/*.java -d bin    # コンパイル
if [ $? = "0" ] ; then
    jar cvfm PDFConverter.jar manifest.mf -C bin ./                         # .jarファイル生成
    clear
    java -jar PDFConverter.jar                                              # .jar実行
    else
        echo 
        echo 

        echo "          Compile Error"

        echo 
        echo 
    fi