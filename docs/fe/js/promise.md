---
title: promise
---
## 1.什么是Promise？

Promise是一个构造函数，这个构造函数可以接收一个函数，执行后返回一个Promise实例，这个实例被叫做 `Promise对象`，就是这么简单！

```js
const fn = () => { 
    console.log(11); 
}

const promise = new Promise(fn)
```

## 2.异步代码执行有什么问题？

当异步操作执行成功或者失败的时候，可能需要执行不同的代码来处理。一般我们会传递不同回调函数进去来解决。

```js
const success = (data) => {
    console.log(data);
}

const fail = (err) => {
    console.log(err);
}

fetch('/api/xxx',success,fail)
```

但是碰到多个异步操作的时候，就会遇到 `回调地狱` 问题。

```js
fetch('/api/xxx', { } ,(data) => {
    fetch('/api/xxx1',data,(data1) => {
         fetch(
            '/api/xxx2',
            data1
            (data2) => {
                fetch('/api/xxx3',data2,() => { },() => { } )
            }
        )
    } )
})
```

即使将函数抽取出来，各个函数之间跳来跳去看也不好理解。

```js
fetch('/api/xxx', {} , success)

const success = (data) => {
    console.log(data);
    fetch('/api/xxx2', data ,success2)
}

const success2 = (data1) => {
    console.log(data1);
    fetch('/api/xxx3', data1 ,success3)
}

const success3 = (data2) => {
  console.log(data2);
  fetch('/api/xxx4', data2 , success4)
}

const success4 = (data2) => {
  console.log(data2);
}
```

## 3.Promise有什么用？

- Promise构造函数接收的函数内部的代码规定都是异步的操作，否则没有必要用Promise

- Promise构造函数接收的函数有两个固定的参数`resolve` 、`reject`

- 当执行`resolve`函数的时候，表示异步代码执行成功，reject表示失败。

- Promise对象有一个`then`方法，`then`方法会在执行`resolve`函数后执行，并且可以接收`resolve`函数传递过来的数据。

- **这样子，本来写在成功的回调函数里的代码可以放在then函数里了**。

- 最大的好处在于`then`方法可以返回一个新的Promise对象，这个新的Promise对象当然也是有then方法的，这样子就可以连续then，把一个个异步调用函数放在一个个then函数中，避免了嵌套，看起来更加直观。

```js
const fn = (resolve,reject) => { 
   fetch('/api/xxx', { } ,(data)=>{
    resolve(data)
   })
}

const promise = new Promise(fn)

promise.then((data)=>{
    // 这里还可以返回一个新的Promise对象
    const fn2 = (resolve,reject) => { 
        fetch('/api/xxx2', data ,(data1)=>{
            resolve(data1)
        })
    }

    const promise2 = new Promise(fn2)
    return promise2
}).then((data2)=>{
    // 拿到了上一个异步代码 fetch('/api/xxx2) 执行后返回的数据
     const fn3 = (resolve,reject) => { 
        fetch('/api/xxx3', data2 ,(data3)=>{
            resolve(data3)
        })
    }

    const promise3 = new Promise(fn3)
    return promise3
}).then((data3)=>{
    // 拿到了上一个异步代码 fetch('/api/xxx3) 执行后返回的数据
    console.log(data3);
})
```
