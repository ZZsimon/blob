---
title: 前言
---

Java技术 前言

不同的平台（Windows、Linux、Mac等）安装不同的Java虚拟机。

Java虚拟机是谁实现的的呢？很多公司都会实现Java虚拟机，但是实现的时候一般都会遵循SUN公司的Java虚拟机规范。否则Java开发者开发的Java程序就很有可能在他们开发的Java虚拟机上跑不了了。

同一个Java程序既可以跑在Windows上，也可以跑在Linux上，是因为他们其实都跑在了各自平台的Java虚拟机上。Java程序需要先编译成“字节码”，不同平台的虚拟机负责加载字节码并执行。