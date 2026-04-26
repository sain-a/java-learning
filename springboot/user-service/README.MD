# 一、项目简介

    本项目是基于 Spring Boot 的用户管理系统，实现了用户的基本 CRUD 功能，并采用分层架构设计。

# 二、技术栈
    Spring Boot
    Spring MVC
    JDBC (JdbcTemplate)
    MySQL
    Maven
# 三、项目结构
    controller  控制层（接收请求）
    service     业务层（业务逻辑）
    dao         数据访问层（数据库操作）
    pojo        实体类
    common      公共类（统一返回Result）
    exception   异常处理
# 四、接口说明（RESTful）
    方法	路径	说明
    GET	/users	查询所有用户
    GET	/users/{id}	查询单个用户
    POST	/users	新增用户
    PUT	/users/{id}	修改用户
    DELETE	/users/{id}	删除用户
# 五、统一返回格式
    {
    "code": 200,
    "message": "操作成功",
    "data": {}
    }
# 六、异常处理
    使用 @RestControllerAdvice 实现全局异常处理
    自定义 BusinessException 处理业务异常
    系统异常统一返回错误信息
# 七、项目特点
    使用 RESTful 风格接口设计
    采用三层架构（Controller → Service → DAO）
    统一返回结构（Result）
    全局异常处理机制
    代码结构清晰，易扩展
# 八、后续优化方向
    使用 MyBatis 替代 JdbcTemplate
    增加参数校验（@Valid）
    集成 Swagger 接口文档
    实现分页查询