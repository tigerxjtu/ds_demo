package controllers

import (
	"github.com/astaxie/beego"
	"gouser/models"
	"strconv"
)

type UserInsertController struct {
	beego.Controller
}

func (this *UserInsertController) Get(){
	this.TplName="toInsertUser.html"
}

func (this *UserInsertController) Post(){
	account:=this.GetString("account")
	age, _ :=strconv.Atoi(this.GetString("age"))
	password:=this.GetString("password")
	sex:=this.GetString("sex")
	userInfo:=models.UserInfo{Account:account,Password:password,Age:age,Sex:sex}
	models.Insert(userInfo)
	this.TplName="success.html"
}
