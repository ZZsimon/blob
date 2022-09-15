---
title: 观察者模式
---
## 1.什么叫做观察者模式？

观察者模式定义了对象之间一对多的依赖关系，当一个对象的状态发生改变时，可以自动通知所有依赖它的对象。

因此，这种模式实现的前提是对象之间有**依赖关系**，并且它有两个对象：观察者、被观察者

1.1 被观察者：可以存储、增加、删除观察者，并且可以将新数据传递给观察者

2.2 观察者：可以接收新数据并且更新

## 2.为什么需要这种模式？

设计观察者模式的目的是为了解决：当对象之间有一对多的依赖关系时，如何方便地通知到观察者

## 3.如何实现观察者模式？

根据1.1的描述，我们可以用 `数组` 这个数据类型来实现存储、增加、删除等功能，再定义 `某个方法` 来实现将新数据传递给观察者。

因此【被观察者】是一个复杂的对象，我们用class来实现它。class中既可以拥有数组，也可以拥有方法。

```js
class Subject {

    constructor(){
        this.observerList=[]
    }

    add(observer){
        this.observerList.push(observer)
    }

    remove(observer){
        this.observerList = this.observerList.filter(item => item!==observer )
    }

    // 该方法可以接收并传递新数据给所有的观察者
    notice(newMsg){
       this.observerList.forEach(observer => {
            // 拿到了每一个观察者
            // 这里可以将数据传递给每一个观察者
            // // 观察者必须拥有update方法 来接收和更新数据
            // observer.update(newMsg)
        });
    }
}

```

根据1.2的描述，我们可以用 `函数` 这个数据类型来实现：接收新数据并且更新

```js
const observer=(newMsg) => { 
    // 拿到了新的数据
    // 更新打印的数据
    console.log(newMsg);
}
```

实现了【观察者】后，我们再继续实现【被观察者】的notice方法

```js

 // 该方法可以接收并传递新数据给所有的观察者
notice(newMsg){
    this.observerList.forEach(observer => {
        // observer是一个函数的话，就可以将新数据传递给它
        observer(newMsg)
    });
}

```
