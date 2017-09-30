# android_project_framework
Base Framework With Dagger2+Butterknife+Retrofit2 Of Android App develop

说明:项目中发起网络请求有可能失败，是因为传的参数的t(token)失效的原因，如果想能正常发送网络请求，请修改为自己可以跑通的接口

接口格式说明：

{
  "success": true,
  "error": [
        {
            msg:"xxx",
            code:-1
        },
        {
            msg:"xxx",
            code:-2
        }
  ],
  "data": {
    "t": "t",
    "ticket": "1483abc92ac37198042b527e7667e0ff",
    "has_invest": "invested",
    "has_open": "opened"
  }
}
