---
title: 类 class
---

## 1.ES6 class 语法
```js
class Animal {
    constructor(name){
        this.name = name
    }

    logName(){
        console.log(this.name)
    }
}

// 使用原生class
const cat = new Animal('cat')
cat.logName() // cat
```

## 2.ES5实现 class
```js
// 使用new语法，说明class是一个构造函数
function Animal(){ }

// new Animal的时候会自动执行constructor方法，这就相当于constructor方法等于构造函数本身
// 他们都是调用方法的时候就会执行，因此constructor方法内部的逻辑可以完全写在Animal函数中
// 该方法内部逻辑需要开发者自行编写
function Animal(name){ 
    this.name = name
}

// 实例可以调用logName方法，说明方法添加到了Animal的原型对象上
Animal.prototype.logName=function(){
    console.log(this.name)
}

// 使用构造函数实现的Animal
const cat = new Animal('cat')
cat.logName() // cat
```