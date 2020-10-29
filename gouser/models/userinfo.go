package models

import (
	"fmt"
	"github.com/astaxie/beego/orm"
	_ "github.com/go-sql-driver/mysql"
)

type UserInfo struct {
	Id int  `orm:"column(id);auto" description:"id"`
	Account string  `orm:"column(account)" description:"account"`
	Password string  `orm:"column(passwordplaintext)" description:"password"`
	Age int `orm:"column(age)"`
	Sex string `orm:"column(sex)"`
}

func (u *UserInfo) TableName() string {
	return "youfands_user"
}

func init(){
	orm.RegisterDriver("mysql", orm.DRMySQL)
	// set default database
	orm.RegisterDataBase("default", "mysql", "root:pass@tcp(127.0.0.1:3306)/dianshang?charset=utf8", 30)
	// register model
	orm.RegisterModel(new(UserInfo))
}

func Insert(userInfo UserInfo){
	o := orm.NewOrm()
	// insert
	id, err := o.Insert(&userInfo)
	fmt.Printf("ID: %d, ERR: %v\n", id, err)
}

func FindUser(id int) UserInfo{
	o := orm.NewOrm()
	var userInfo UserInfo
	err:= o.Raw("select id,account,passwordplaintext,age,sex from youfands_user where id=?", id).QueryRow(&userInfo)
	if err!=nil {
		fmt.Println("find user error: ", err)
	}
	return userInfo
}
