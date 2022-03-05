# springboot学习案例代码
>默认端口8090, 可在配置文件中修改
>
>数据库运行在服务器上, 可直接使用
## 接口

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