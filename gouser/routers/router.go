package routers

import (
	"gouser/controllers"
	beego "github.com/astaxie/beego"
)

func init() {
    beego.Router("/", &controllers.MainController{})
    beego.Router("/toInsertUser",&controllers.UserInsertController{})
	beego.Router("/insertUser",&controllers.UserInsertController{})
	beego.Router("/findUser",&controllers.UserFindController{})

	beego.Router("/health", &controllers.HealthController{})
}
