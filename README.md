# BingWallPaper
拉取每日并应的图片


##代码解析

1 .  https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1  
    通过该URL获取并应图片的信息  
    
``
{
"images": [
{
"startdate": "20190531",
"fullstartdate": "201905311600",
"enddate": "20190601",
"url": "/th?id=OHR.HighTrestleTrail_ZH-CN4499525731_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
"urlbase": "/th?id=OHR.HighTrestleTrail_ZH-CN4499525731",
"copyright": "爱荷华州中部的高架栈桥 (© Kelly van Dellen/Getty Images Plus)",
"copyrightlink": "http://www.bing.com/search?q=%E9%AB%98%E6%9E%B6%E6%A0%88%E6%A1%A5&form=hpcapt&mkt=zh-cn",
"title": "",
"quiz": "/search?q=Bing+homepage+quiz&filters=WQOskey:%22HPQuiz_20190531_HighTrestleTrail%22&FORM=HPQUIZ",
"wp": true,
"hsh": "bfbb0cc9eb8bd1ca5c1942723933f7d3",
"drk": 1,
"top": 1,
"bot": 1,
"hs": []
}
],
"tooltips": {
"loading": "正在加载...",
"previous": "上一个图像",
"next": "下一个图像",
"walle": "此图片不能下载用作壁纸。",
"walls": "下载今日美图。仅限用作桌面壁纸。"
}
}
``

2 .将JSON数据转换为实体类  获取bing图片的地址并拼接上 `http://s.cn.bing.net`

3 .将图片下载到本地并写入下载日志

4 .开启定时任务，每天凌晨开始运行，每隔半个小时运行一次


5 .编写javaProgramStart.bat 其内容为：start javaw -jar wallpaper.jar

6 .创建该bat的快捷方式

7 .将该快捷方式放在windows的开机启动文件夹内  
其位置为：C:\ProgramData\Microsoft\Windows\Start Menu\Programs\StartUp

