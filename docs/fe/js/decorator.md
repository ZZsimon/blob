---
title: 装饰器 Decorator
---

## 1.Decorator是什么？
Decorator是一种新的js语法，使用这种语法可以**注释或者修改** `类以及类的方法` 。Decorator本质上是一种函数，使用 `@函数名` 这种格式写在类和类方法前面。

## 2.装饰类
```js
function addOneNumber(target){ target.num = 1 }
@addOneNumber
class Animal { }

// 相当于这样子写，往类上添加属性
// 通过函数的方式，而不是Animal.num = 1，这样子直接修改类
class Animal {}
addOneNumber(Animal)
```

```js
// 如果觉得装饰器一个函数不够用，可以在装饰器函数外面在套一个函数
function addNumber(num){
    return function(target){
        target.num = num
    }
}
@addNumber(2)
class Animal { }

// 相当于
class Animal {}
addNumber(2)(A)
```
## 3.编译时运行的Decorator
- 装饰器对类的行为的改变，是**代码编译时**发生的，而不是在运行时。
- 这意味着，装饰器能在编译阶段运行代码。
- 也就是说，装饰器本质就是编译时执行的函数,而不是运行时执行的函数。我们一般写的函数都是运行代码的时候才会执行。
```js
// 还没有使用函数执行语法 addoneNumber() ，此时Animal类已经被修改了
// 只是用了 @语法，此时Animal类已经被修改了
function addOneNumber(target) { target.num = 1 }

@addOneNumber
class Animal { }

console.log(Animal.num, 'Animal.num') // 直接输出了 1
```

## 4.装饰类的属性（增加属性）
```js
function addOneNumber(target){
  target.prototype.num = 1
}

@addOneNumber
class Animal { }

const animal = new Animal()
console.log(animal.num, 'animal.num') // 1
```

## 5.装饰类的属性（修改属性）
```js
// 装饰类的属性的时候，target表示类的原型对象
// 修改了对象的descriptor属性后，直接返回了新的descriptor
// 这个新的descriptor又会作用于log这个属性
function readonly(target,name,descriptor){
  descriptor.writable = false
  return descriptor
}


class Animal {
  @readonly
  log(){
    console.log('test readonly')
  }

}

const cat = new Animal()
cat.log() // test readonly
cat.log = "I can't change the log function" // 不会生效 
```

## 6.装饰类的属性（日志功能）
```js
/**
 * descriptor.value表示属性本身，log装饰器修饰了eat方法,这里就表示【eat方法】
 * 调用eat的时候，需要额外打印出日志，因此需要修改这个方法本身，也就是descriptor.value
 */
function log(target,name,descriptor){
  const oldValue = descriptor.value
  descriptor.value = function() {
    console.log(`修饰的方法：【${name}】，执行时间：${new Date()}`, 'log：输出当前属性的name和当前方法执行的时间')

    // 相当于在外面调用老的eat方法，然后返回了 老的eat方法的返回值
    // 上面的输出代码就是额外增加的功能
    return oldValue.apply(this, arguments);
  };
  return descriptor;
}


class Animal {
  @log
  eat(){
    console.log('eat')
  }

}

const cat = new Animal()
cat.eat() // 输出 1.eat  2.修饰的方法：xxxxxxxxxxxxxxxxxxxxx
```



## 7.多个装饰器
```js
function dec(id){
  console.log('evaluated', id);
  return (target, property, descriptor) => console.log('executed', id);
}
class Example {
    @dec(1)
    @dec(2)
    method(){}
}
// evaluated 1
// evaluated 2
// executed 2
// executed 1
```


[Decorator Demo地址](https://github.com/ZZsimon/decorator-demo)
