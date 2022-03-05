# 基于Spring Boot和Vue的前后端分离的简易学生信息管理系统

> 本项目为个人学习所创建, 前后端实现都比较简单基础, 适合初入门的同学学习, 体验一下前后端如何连接交互以及前后端分离的优点

## 后端

> 使用Spring Boot+MyBatis+Maven



>默认端口8090, 可在配置文件中修改
>
>数据库运行在服务器上, 可直接使用
### 接口

- 查询所有用户(get): 127.0.0.1:8090/user/findAll

  ![image-20220305110949913](https://oss.zaqai.com/img/image-20220305110949913.png)

- 根据用户名查找用户(get): 127.0.0.1:8090/user/find?username=XX

  ![image-20220305110848942](https://oss.zaqai.com/img/image-20220305110848942.png)

- 根据id删除用户(get): 127.0.0.1:8090/user/delete?id=XX

  ![image-20220305110931761](https://oss.zaqai.com/img/image-20220305110931761.png)

- 根据id修改用户(post): 127.0.0.1:8090/user/update

  ![image-20220305110616524](https://oss.zaqai.com/img/image-20220305110616524.png)

- 添加用户(post): 127.0.0.1:8090/user/add

  ![image-20220305110539064](https://oss.zaqai.com/img/image-20220305110539064.png)



## 前端

> 使用Vue+Element UI



`npm install`

`npm run dev`

### 效果截图

![image-20220305111326679](https://oss.zaqai.com/img/image-20220305111326679.png)

### 删除操作

![image-20220305111355975](https://oss.zaqai.com/img/image-20220305111355975.png)

### 修改操作



![image-20220305111425629](https://oss.zaqai.com/img/image-20220305111425629.png)




