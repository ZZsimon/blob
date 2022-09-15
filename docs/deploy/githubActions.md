---
title: GitHub Actions
---


## Actions
持续集成由`很多操作`组成，比如*抓取代码*、*运行测试*、*登录远程服务器*，*发布到第三方服务*等等。GitHub 把`这些操作`就称为 `actions`。

**很多操作在不同项目里面是类似的，完全可以共享**。GitHub 注意到了这一点，想出了一个很妙的点子，允许开发者把每个操作写成独立的脚本文件，存放到代码仓库，使得其他开发者可以引用。

如果需要某个action，直接使用别人写好的就行。整个持续集成过程，就变成了一个 **actions 的组合**。这就是 GitHub Actions 最特别的地方。

## Action 仓库
每个action其实就是一段脚本，这段脚本的作者就可以创建一个仓库来保存这段脚本。使用 `userName/repoName` 的语法引用 action。

## 参考链接
- [github actions教程 阮一峰](https://www.ruanyifeng.com/blog/2019/09/getting-started-with-github-actions.html)

