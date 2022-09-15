---
title: GitHub Actions
---


## Actions
持续集成由`很多操作`组成，比如*抓取代码*、*运行测试*、*登录远程服务器*，*发布到第三方服务*等等。GitHub 把`这些操作`就称为 `actions`。

**很多操作在不同项目里面是类似的，完全可以共享**。GitHub 注意到了这一点，想出了一个很妙的点子，允许开发者把每个操作写成独立的脚本文件，存放到代码仓库，使得其他开发者可以引用。

如果需要某个action，直接使用别人写好的就行。整个持续集成过程，就变成了一个 **actions 的组合**。这就是 GitHub Actions 最特别的地方。

## Action 仓库
每个action其实就是一段脚本，这段脚本的作者就可以创建一个仓库来保存这段脚本。使用 `userName/repoName` 的语法引用 action。

```yaml
# 使用其他人制作的actions例子
# userName -> JamesIves
# repoName -> github-pages-deploy-action@v4
# 这个action仓库的作用就是 自动部署指定文件夹中的静态文件到github page上
- name: Deploy 🚀
  uses: JamesIves/github-pages-deploy-action@v4
  with:
    folder: docs/.vuepress/dist
```

## 配置文件
使用GitHub Actions，需要在项目中创建 `.github/workflows` 目录，在目录下创建 `.yml` 格式文件。GitHub 只要发现 `.github/workflows` 目录里面有 `.yml` 文件，就会自动运行该文件。

这个文件有一套自己的语法：
- workflow （工作流程）：持续集成一次运行的过程，就是一个 workflow。
- job （任务）：一个 workflow 由一个或多个 jobs 构成，含义是一次持续集成的运行，可以完成多个任务。
- step（步骤）：每个 job 由多个 step 构成，一步步完成。
- action （动作）：每个 step 可以依次执行一个或多个命令（action）。

```yaml
# name表示当前这个workflow的名称
name: GitHub Actions Build and Deploy GitHub Pages
# on表示push动作发生的时候，就会执行当前这个 workflow
on: [push]
# jobs表示当前的任务
# 当前只有一个任务 build-and-deploy，这个任务名称可以自己随便取
jobs:
  build-and-deploy:
# runs-on表示依赖运行需要的虚拟机环境，这里是 ubuntu-latest
    runs-on: ubuntu-latest
# 一个job可以分为多个step，按照顺序来执行，这里有3个step
    steps:
      - name: Checkout 🛎️
        uses: actions/checkout@v3

      - name: Install and Build 🔧 
        run: |
          npm install
          npm run build

      - name: Deploy 🚀
        uses: JamesIves/github-pages-deploy-action@v4
        with:
          folder: docs/.vuepress/dist
```

## 参考链接
- [github actions教程 阮一峰](https://www.ruanyifeng.com/blog/2019/09/getting-started-with-github-actions.html)


