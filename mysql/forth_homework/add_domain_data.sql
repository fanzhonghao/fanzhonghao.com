use school_roll;
set character_set_client=utf8;
insert into domain/*软件工程学院*/
  values ("软件工程","软件工程学院");

insert into domain/*通信工程学院*/
  values ("通信工程","通信工程学院"),
  ("信息安全","通信工程学院"),
  ("空间信息与数字技术","通信工程学院"),/*空间信息与数字技术*/
  ("信息工程","通信工程学院");/*信息工程*/
  use school_roll;

  insert into domain/*电子工程学院*/
    values ("电子信息工程","电子工程学院"),/*电子信息工程*/
    ("信息对抗技术","电子工程学院"),/*信息对抗技术*/
    ("智能科学与技术","电子工程学院"),/*智能科学与技术*/
    ("电磁场与无线电技术","电子工程学院"),/*电磁场与无线电技术*/
    ("遥感科学与技术*","电子工程学院");/*遥感科学与技术*/

  insert into domain/*计算机学院*/
    values ("计算机科学与技术","计算机学院"),/*计算机科学与技术*/
    ("网络工程","计算机学院"),/*网络工程*/
    ("技术学","计算机学院"),/*技术学*/
    ("教育","计算机学院");/*教育*/

  insert into domain/*机电院*/
    values ("机械设计制造及其自动化","机电院"),/*机械设计制造及其自动化*/
    ("工业设计","机电院"),/*工业设计*/
    ("自动化","机电院"),/*自动化*/
    ("电气工程及其自动化","机电院"),/*电气工程及其自动化*/
    ("测控技术与仪器","机电院"),/*测控技术与仪器*/
    ("电子封装技术","机电院");/*电子封装技术*/

  insert into domain/*物理与光电工程学院*/
    values ("电子科学与技术","物理与光电工程学院"),/*电子科学与技术*/
    ("光电信息科学与工程","物理与光电工程学院"),/*光电信息科学与工程*/
    ("电子信息科学与技术","物理与光电工程学院"),/*电子信息科学与技术*/
    ("应用物理学","物理与光电工程学院"),/*应用物理学*/
    ("电波传播天线","物理与光电工程学院");/*电波传播天线*/

  insert into domain/*经济管理学院*/
    values ("信息管理与信息系统","经济管理学院"),/*信息管理与信息系统*/
    ("工商管理","经济管理学院"),/*工商管理*/
    ("工业工程","经济管理学院"),/*工业工程*/
    ("金融学","经济管理学院"),/*金融学*/
    ("电子商务","经济管理学院"),/*电子商务*/
    ("市场营销","经济管理学院"),/*市场营销*/
    ("人力资源管理*","经济管理学院"),/*人力资源管理*/
    ("行政管理","经济管理学院"),/*行政管理*/
    ("劳动与社会保障","经济管理学院");/*劳动与社会保障*/

  insert into domain/*数学与统计*/
    values ("数学与应用数学","数学与统计"),/*数学与应用数学*/
    ("统计学","数学与统计"),/*统计学*/
    ("信息与计算科学","数学与统计");/*信息与计算科学*/

  insert into domain /*人文学院*/
    values ("心理学","人文学院"),/*心理学*/
    ("哲学","人文学院"),/*哲学*/
    ("政治学","人文学院"),/*政治学*/
    ("中文","人文学院"),/*中文*/
    ("历史学","人文学院"),/*历史学*/
    ("艺术学","人文学院");/*艺术学*/

  insert into domain /*外国语学院*/
    values ("英语","外国语学院"),/*英语*/
    ("日语","外国语学院");/*日语*/

  insert into domain /*微电子学院*/
    values ("微电子与固体电子学","微电子学院"),/*微电子与固体电子学*/
    ("集成电路设计与集成系统","微电子学院");/*集成电路设计与集成系统*/

  insert into domain/*生命科学技术学院*/
    values ("生物医学工程","生命科学技术学院"),/*生物医学工程*/
    ("生物技术","生命科学技术学院");/*生物技术*/

  insert into domain/*空间科学与技术学院*/
    values ("探测制导与控制技术","空间科学与技术学院"),
    ("空间科学与技术","空间科学与技术学院"),/*空间科学与技术*/
    ("导航工程和飞行器设计与工程","空间科学与技术学院");/*导航工程和飞行器设计与工程*/
