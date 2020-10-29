package controllers

import (
	"fmt"
	"github.com/astaxie/beego"
	"gouser/models"
	"strconv"
)

type UserFindController struct {
	beego.Controller
}

func (this *UserFindController) Get() {
	id,_:=strconv.Atoi(this.GetString("id"));

	userInfo:=models.FindUser(id)
	this.Data["json"]=userInfo
	this.ServeJSON()
	fmt.Println(userInfo)
	return
}

