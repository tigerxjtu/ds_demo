package controllers

import "github.com/astaxie/beego"

type HealthController struct {
	beego.Controller
}
func (this *HealthController) Get() {
	this.Data["json"] = map[string]interface{}{
		"status": "UP"}
	this.ServeJSON()
	return
}


