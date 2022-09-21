---
title: 控制反转（IoC）
---

## 1.什么是IoC？
IoC它的全称叫做 `Inversion of Control`，可翻译为为「控制反转」或「依赖倒置」。IoC首先是一种思想，基于这个思想，可以有很多的实现方式。IoC这个思想主要包含了三个准则：
- 高层次的模块不应该依赖于低层次的模块，它们都应该依赖于抽象
- 抽象不应该依赖于具体实现，具体实现应该依赖于抽象
- **面向接口编程**而不要面向实现编程

## 2.IoC出现的背景
先使用一个简单的例子来理解Ioc
```js
// app.js
import Router from './modules/Router';
import Track from './modules/Track';

class App {
    constructor(options) {
        this.options = options;
        this.router = new Router();
        this.track = new Track();
        this.init();
    }

    init() {
        this.router.to('home');
        this.track.tracking();
    }
}

// index.js
import App from 'path/to/App';
new App();
```

如果router模块需要新增 `history模式` ，不仅要改**router模块**代码，还需要修改**App模块**：`new Router({ mode: 'history' })`

这就出现问题了，我们并不想要修改**App代码**。那么怎么解决呢？

事实上，这个问题的本质是模块之间的依赖问题。`App模块`是高层模块，其他模块是底层模块。`App模块` 依赖了**Router模块**和**Track模块**，内部直接使用了底层模块，导致一旦修改了底层模块，`App模块` 就需要相应的修改。

## 3.DI（依赖注入）
把App所依赖的模块通过传递参数的方式注入到App内部去，让App内部不再依赖具体的模块，这就是 `DI（依赖注入）`。

本质上，IoC思想的目的就是将**依赖解耦**，而 `DI（依赖注入）` 就是一种**基于IoC思想**实现的一种编程方式，这种编程方式解决了高层模块和底层模块互相依赖的问题。
```js
// app.js
import Router from './modules/Router';
import Track from './modules/Track';

class App {
    constructor(options) {
        this.options = options;
        this.router = options.router
        this.router = options.track
        this.init();
    }

    init() {
        this.router.to('home');
        this.track.tracking();
    }
}

// index.js
import App from 'path/to/App';
new App({
    router:new Router({ mode: 'history' }),
    track:new Track(),
});
```
但是如果此时，App模块需要增加一个分享模块 `Share` ，那又要修改**App代码**了。需要添加代码 `this.share = options.share`

虽然 App 通过依赖注入的方式在一定程度上解耦了与其他几个模块的依赖关系，但是还不够彻底。

**IoC设计模式**要求模块（比如App模块）需要依赖抽象，而不是具体的实现。这里App所依赖的传入的参数`this.router`、`this.track`、`this.share`都是一些具体的实现，而不是抽象的概念。

也就是说此时实现的“依赖注入”，并不符合IoC的思想。

## 4.DIP（依赖反转原则）
`依赖反转原则（Dependency inversion principle，DIP）` 规定：
- 高层次的模块不应该依赖与低层次的模块，两者都应该依赖于抽象接口。
- 抽象接口不应该依赖于具体实现。而具体实现则应该依赖于抽象接口。

把App模块中的**具体实现**（this.router、this.track、this.share）抽象出来，内部的 `use` 方法可以将模块保存到 `modules` 这个数组中。通过 `initModules` 可以初始化每个模块，而不是直接依赖这些模块。

此时，App内部已经没有具体的业务逻辑了，但是它要求每个模块都需要一个 `init方法` 来初始化模块。而这就是遵循了 `DIP以及IoC的思想 - 面向接口编程而不是实现编程`。此时App内部的代码依赖的是 `init方法` 这个接口，而不是具体的业务代码。
```js
// app.js
import Router from './modules/Router';
import Track from './modules/Track';

class App {
    static modules = []
    static use(module) {
        Array.isArray(module) ? module.map(item => App.use(item)) : App.modules.push(module);
    }

    constructor(options) {
        this.options = options;
        this.init();
    }

    init() {
         this.initModules();
    }

     initModules() {
        App.modules.map(module => module.init(this));
    }
}
```

```js
// modules/Router.js
import Router from 'path/to/Router';
export default {
    init(app) {
        app.router = new Router(app.options.router);
    }
};

// modules/Track.js
import Track from 'path/to/Track';
export default {
    init(app) {
        app.track = new Track(app.options.track);
        app.track.tracking();
    }
};

// index.js
import App from 'path/to/App';
import Router from './modules/Router';
import Track from './modules/Track';

App.use([Router, Track]);

new App({
    router: {
        mode: 'history',
    },
    track: {
        // ...
    },
});
```

## 5.总结
**IoC首先是一种思想**，`依赖注入` 是基于Ioc思想实现的一种编程方式。而这里的App是一个 `IoC容器`，它可以添加、管理依赖。