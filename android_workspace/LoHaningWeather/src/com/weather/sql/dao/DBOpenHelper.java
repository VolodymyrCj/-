package com.weather.sql.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

	static DBOpenHelper mInstance = null; 
	private static final int VERSION=1;
	private static final String DBNAME="weather.db";
	
	public DBOpenHelper(Context context) {
		super(context,DBNAME,null,VERSION);
		// TODO Auto-generated constructor stub
	}

	
	
	  
	  
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table tb_city(_id integer primary key,city String)");//创建已选城市表
		
		/*db.execSQL("create table tb_inaccount(_id integer primary key,money double,time varchar(10),"+
				"type varchar(10),hands varchar(50),mark varchar(200))");//创建收入信息表
		
		db.execSQL("create table tb_pwd(pwd varchar(20))");//创建密码表
		
		db.execSQL("create table tb_flag(_id integer primary key,flag varchar(200))");//创建便签信息表
*/
		db.execSQL("CREATE TABLE IF NOT EXISTS city(_id int(11) NOT NULL PRIMARY KEY,code varchar(6) NOT NULL,"
				+ "name varchar(20) NOT NULL,provincecode varchar(6) NOT NULL)");
        
		db.execSQL("INSERT INTO  city ('_id', 'code', 'name', 'provincecode') VALUES\n" +
                "(1, '110100', '北京市', '110000'),\n" +
                "(2, '130100', '石家庄市', '130000'),\n" +
                "(3, '130200', '唐山市', '130000'),\n" +
                "(4, '130300', '秦皇岛市', '130000'),\n" +
                "(5, '130400', '邯郸市', '130000'),\n" +
                "(6, '130500', '邢台市', '130000'),\n" +
                "(7, '130600', '保定市', '130000'),\n" +
                "(8, '130700', '张家口市', '130000'),\n" +
                "(9, '130800', '承德市', '130000'),\n" +
                "(10, '130900', '沧州市', '130000'),\n" +
                "(11, '131000', '廊坊市', '130000'),\n" +
                "(12, '131100', '衡水市', '130000'),\n" +
                "(13, '140100', '太原市', '140000'),\n" +
                "(14, '140200', '大同市', '140000'),\n" +
                "(15, '140300', '阳泉市', '140000'),\n" +
                "(16, '140400', '长治市', '140000'),\n" +
                "(17, '140500', '晋城市', '140000'),\n" +
                "(18, '140600', '朔州市', '140000'),\n" +
                "(19, '140700', '晋中市', '140000'),\n" +
                "(20, '140800', '运城市', '140000'),\n" +
                "(21, '140900', '忻州市', '140000'),\n" +
                "(22, '141000', '临汾市', '140000'),\n" +
                "(23, '141100', '吕梁市', '140000'),\n" +
                "(24, '150100', '呼和浩特市', '150000'),\n" +
                "(25, '150200', '包头市', '150000'),\n" +
                "(26, '150300', '乌海市', '150000'),\n" +
                "(27, '150400', '赤峰市', '150000'),\n" +
                "(28, '150500', '通辽市', '150000'),\n" +
                "(29, '150600', '鄂尔多斯市', '150000'),\n" +
                "(30, '150700', '呼伦贝尔市', '150000'),\n" +
                "(31, '150800', '巴彦淖尔市', '150000'),\n" +
                "(32, '150900', '乌兰察布市', '150000'),\n" +
                "(33, '152200', '兴安盟', '150000'),\n" +
                "(34, '152500', '锡林郭勒盟', '150000'),\n" +
                "(35, '152900', '阿拉善盟', '150000'),\n" +
                "(36, '210100', '沈阳市', '210000'),\n" +
                "(37, '210200', '大连市', '210000'),\n" +
                "(38, '210300', '鞍山市', '210000'),\n" +
                "(39, '210400', '抚顺市', '210000'),\n" +
                "(40, '210500', '本溪市', '210000'),\n" +
                "(41, '210600', '丹东市', '210000'),\n" +
                "(42, '210700', '锦州市', '210000'),\n" +
                "(43, '210800', '营口市', '210000'),\n" +
                "(44, '210900', '阜新市', '210000'),\n" +
                "(45, '211000', '辽阳市', '210000'),\n" +
                "(46, '211100', '盘锦市', '210000'),\n" +
                "(47, '211200', '铁岭市', '210000'),\n" +
                "(48, '211300', '朝阳市', '210000'),\n" +
                "(49, '211400', '葫芦岛市', '210000'),\n" +
                "(50, '220100', '长春市', '220000'),\n" +
                "(51, '220200', '吉林市', '220000'),\n" +
                "(52, '220300', '四平市', '220000'),\n" +
                "(53, '220400', '辽源市', '220000'),\n" +
                "(54, '220500', '通化市', '220000'),\n" +
                "(55, '220600', '白山市', '220000'),\n" +
                "(56, '220700', '松原市', '220000'),\n" +
                "(57, '220800', '白城市', '220000'),\n" +
                "(58, '222400', '延边朝鲜族自治州', '220000'),\n" +
                "(59, '230100', '哈尔滨市', '230000'),\n" +
                "(60, '230200', '齐齐哈尔市', '230000'),\n" +
                "(61, '230300', '鸡西市', '230000'),\n" +
                "(62, '230400', '鹤岗市', '230000'),\n" +
                "(63, '230500', '双鸭山市', '230000'),\n" +
                "(64, '230600', '大庆市', '230000'),\n" +
                "(65, '230700', '伊春市', '230000'),\n" +
                "(66, '230800', '佳木斯市', '230000'),\n" +
                "(67, '230900', '七台河市', '230000'),\n" +
                "(68, '231000', '牡丹江市', '230000'),\n" +
                "(69, '231100', '黑河市', '230000'),\n" +
                "(70, '231200', '绥化市', '230000'),\n" +
                "(71, '232700', '大兴安岭地区', '230000'),\n" +
                "(72, '310100', '市辖区', '310000'),\n" +
                "(73, '310200', '县', '310000'),\n" +
                "(74, '320100', '南京市', '320000'),\n" +
                "(75, '320200', '无锡市', '320000'),\n" +
                "(76, '320300', '徐州市', '320000'),\n" +
                "(77, '320400', '常州市', '320000'),\n" +
                "(78, '320500', '苏州市', '320000'),\n" +
                "(79, '320600', '南通市', '320000'),\n" +
                "(80, '320700', '连云港市', '320000'),\n" +
                "(81, '320800', '淮安市', '320000'),\n" +
                "(82, '320900', '盐城市', '320000'),\n" +
                "(83, '321000', '扬州市', '320000'),\n" +
                "(84, '321100', '镇江市', '320000'),\n" +
                "(85, '321200', '泰州市', '320000'),\n" +
                "(86, '321300', '宿迁市', '320000'),\n" +
                "(87, '330100', '杭州市', '330000'),\n" +
                "(88, '330200', '宁波市', '330000'),\n" +
                "(89, '330300', '温州市', '330000'),\n" +
                "(90, '330400', '嘉兴市', '330000'),\n" +
                "(91, '330500', '湖州市', '330000'),\n" +
                "(92, '330600', '绍兴市', '330000'),\n" +
                "(93, '330700', '金华市', '330000'),\n" +
                "(94, '330800', '衢州市', '330000'),\n" +
                "(95, '330900', '舟山市', '330000'),\n" +
                "(96, '331000', '台州市', '330000'),\n" +
                "(97, '331100', '丽水市', '330000'),\n" +
                "(98, '340100', '合肥市', '340000'),\n" +
                "(99, '340200', '芜湖市', '340000'),\n" +
                "(100, '340300', '蚌埠市', '340000'),\n" +
                "(101, '340400', '淮南市', '340000'),\n" +
                "(102, '340500', '马鞍山市', '340000'),\n" +
                "(103, '340600', '淮北市', '340000'),\n" +
                "(104, '340700', '铜陵市', '340000'),\n" +
                "(105, '340800', '安庆市', '340000'),\n" +
                "(106, '341000', '黄山市', '340000'),\n" +
                "(107, '341100', '滁州市', '340000'),\n" +
                "(108, '341200', '阜阳市', '340000'),\n" +
                "(109, '341300', '宿州市', '340000'),\n" +
                "(110, '341400', '巢湖市', '340000'),\n" +
                "(111, '341500', '六安市', '340000'),\n" +
                "(112, '341600', '亳州市', '340000'),\n" +
                "(113, '341700', '池州市', '340000'),\n" +
                "(114, '341800', '宣城市', '340000'),\n" +
                "(115, '350100', '福州市', '350000'),\n" +
                "(116, '350200', '厦门市', '350000'),\n" +
                "(117, '350300', '莆田市', '350000'),\n" +
                "(118, '350400', '三明市', '350000'),\n" +
                "(119, '350500', '泉州市', '350000'),\n" +
                "(120, '350600', '漳州市', '350000'),\n" +
                "(121, '350700', '南平市', '350000'),\n" +
                "(122, '350800', '龙岩市', '350000'),\n" +
                "(123, '350900', '宁德市', '350000'),\n" +
                "(124, '360100', '南昌市', '360000'),\n" +
                "(125, '360200', '景德镇市', '360000'),\n" +
                "(126, '360300', '萍乡市', '360000'),\n" +
                "(127, '360400', '九江市', '360000'),\n" +
                "(128, '360500', '新余市', '360000'),\n" +
                "(129, '360600', '鹰潭市', '360000'),\n" +
                "(130, '360700', '赣州市', '360000'),\n" +
                "(131, '360800', '吉安市', '360000'),\n" +
                "(132, '360900', '宜春市', '360000'),\n" +
                "(133, '361000', '抚州市', '360000'),\n" +
                "(134, '361100', '上饶市', '360000'),\n" +
                "(135, '370100', '济南市', '370000'),\n" +
                "(136, '370200', '青岛市', '370000'),\n" +
                "(137, '370300', '淄博市', '370000'),\n" +
                "(138, '370400', '枣庄市', '370000'),\n" +
                "(139, '370500', '东营市', '370000'),\n" +
                "(140, '370600', '烟台市', '370000'),\n" +
                "(141, '370700', '潍坊市', '370000'),\n" +
                "(142, '370800', '济宁市', '370000'),\n" +
                "(143, '370900', '泰安市', '370000'),\n" +
                "(144, '371000', '威海市', '370000'),\n" +
                "(145, '371100', '日照市', '370000'),\n" +
                "(146, '371200', '莱芜市', '370000'),\n" +
                "(147, '371300', '临沂市', '370000'),\n" +
                "(148, '371400', '德州市', '370000'),\n" +
                "(149, '371500', '聊城市', '370000'),\n" +
                "(150, '371600', '滨州市', '370000'),\n" +
                "(151, '371700', '荷泽市', '370000'),\n" +
                "(152, '410100', '郑州市', '410000'),\n" +
                "(153, '410200', '开封市', '410000'),\n" +
                "(154, '410300', '洛阳市', '410000'),\n" +
                "(155, '410400', '平顶山市', '410000'),\n" +
                "(156, '410500', '安阳市', '410000'),\n" +
                "(157, '410600', '鹤壁市', '410000'),\n" +
                "(158, '410700', '新乡市', '410000'),\n" +
                "(159, '410800', '焦作市', '410000'),\n" +
                "(160, '410900', '濮阳市', '410000'),\n" +
                "(161, '411000', '许昌市', '410000'),\n" +
                "(162, '411100', '漯河市', '410000'),\n" +
                "(163, '411200', '三门峡市', '410000'),\n" +
                "(164, '411300', '南阳市', '410000'),\n" +
                "(165, '411400', '商丘市', '410000'),\n" +
                "(166, '411500', '信阳市', '410000'),\n" +
                "(167, '411600', '周口市', '410000'),\n" +
                "(168, '411700', '驻马店市', '410000'),\n" +
                "(169, '420100', '武汉市', '420000'),\n" +
                "(170, '420200', '黄石市', '420000'),\n" +
                "(171, '420300', '十堰市', '420000'),\n" +
                "(172, '420500', '宜昌市', '420000'),\n" +
                "(173, '420600', '襄樊市', '420000'),\n" +
                "(174, '420700', '鄂州市', '420000'),\n" +
                "(175, '420800', '荆门市', '420000'),\n" +
                "(176, '420900', '孝感市', '420000'),\n" +
                "(177, '421000', '荆州市', '420000'),\n" +
                "(178, '421100', '黄冈市', '420000'),\n" +
                "(179, '421200', '咸宁市', '420000'),\n" +
                "(180, '421300', '随州市', '420000'),\n" +
                "(181, '422800', '恩施土家族苗族自治州', '420000'),\n" +
                "(182, '429000', '省直辖行政单位', '420000'),\n" +
                "(183, '430100', '长沙市', '430000'),\n" +
                "(184, '430200', '株洲市', '430000'),\n" +
                "(185, '430300', '湘潭市', '430000'),\n" +
                "(186, '430400', '衡阳市', '430000'),\n" +
                "(187, '430500', '邵阳市', '430000'),\n" +
                "(188, '430600', '岳阳市', '430000'),\n" +
                "(189, '430700', '常德市', '430000'),\n" +
                "(190, '430800', '张家界市', '430000'),\n" +
                "(191, '430900', '益阳市', '430000'),\n" +
                "(192, '431000', '郴州市', '430000'),\n" +
                "(193, '431100', '永州市', '430000'),\n" +
                "(194, '431200', '怀化市', '430000'),\n" +
                "(195, '431300', '娄底市', '430000'),\n" +
                "(196, '433100', '湘西土家族苗族自治州', '430000'),\n" +
                "(197, '440100', '广州市', '440000'),\n" +
                "(198, '440200', '韶关市', '440000'),\n" +
                "(199, '440300', '深圳市', '440000'),\n" +
                "(200, '440400', '珠海市', '440000'),\n" +
                "(201, '440500', '汕头市', '440000'),\n" +
                "(202, '440600', '佛山市', '440000'),\n" +
                "(203, '440700', '江门市', '440000'),\n" +
                "(204, '440800', '湛江市', '440000'),\n" +
                "(205, '440900', '茂名市', '440000'),\n" +
                "(206, '441200', '肇庆市', '440000'),\n" +
                "(207, '441300', '惠州市', '440000'),\n" +
                "(208, '441400', '梅州市', '440000'),\n" +
                "(209, '441500', '汕尾市', '440000'),\n" +
                "(210, '441600', '河源市', '440000'),\n" +
                "(211, '441700', '阳江市', '440000'),\n" +
                "(212, '441800', '清远市', '440000'),\n" +
                "(213, '441900', '东莞市', '440000'),\n" +
                "(214, '442000', '中山市', '440000'),\n" +
                "(215, '445100', '潮州市', '440000'),\n" +
                "(216, '445200', '揭阳市', '440000'),\n" +
                "(217, '445300', '云浮市', '440000'),\n" +
                "(218, '450100', '南宁市', '450000'),\n" +
                "(219, '450200', '柳州市', '450000'),\n" +
                "(220, '450300', '桂林市', '450000'),\n" +
                "(221, '450400', '梧州市', '450000'),\n" +
                "(222, '450500', '北海市', '450000'),\n" +
                "(223, '450600', '防城港市', '450000'),\n" +
                "(224, '450700', '钦州市', '450000'),\n" +
                "(225, '450800', '贵港市', '450000'),\n" +
                "(226, '450900', '玉林市', '450000'),\n" +
                "(227, '451000', '百色市', '450000'),\n" +
                "(228, '451100', '贺州市', '450000'),\n" +
                "(229, '451200', '河池市', '450000'),\n" +
                "(230, '451300', '来宾市', '450000'),\n" +
                "(231, '451400', '崇左市', '450000'),\n" +
                "(232, '460100', '海口市', '460000'),\n" +
                "(233, '460200', '三亚市', '460000'),\n" +
                "(234, '469000', '省直辖县级行政单位', '460000'),\n" +
                "(235, '500100', '市辖区', '500000'),\n" +
                "(236, '500200', '县', '500000'),\n" +
                "(237, '500300', '市', '500000'),\n" +
                "(238, '510100', '成都市', '510000'),\n" +
                "(239, '510300', '自贡市', '510000'),\n" +
                "(240, '510400', '攀枝花市', '510000'),\n" +
                "(241, '510500', '泸州市', '510000'),\n" +
                "(242, '510600', '德阳市', '510000'),\n" +
                "(243, '510700', '绵阳市', '510000'),\n" +
                "(244, '510800', '广元市', '510000'),\n" +
                "(245, '510900', '遂宁市', '510000'),\n" +
                "(246, '511000', '内江市', '510000'),\n" +
                "(247, '511100', '乐山市', '510000'),\n" +
                "(248, '511300', '南充市', '510000'),\n" +
                "(249, '511400', '眉山市', '510000'),\n" +
                "(250, '511500', '宜宾市', '510000'),\n" +
                "(251, '511600', '广安市', '510000'),\n" +
                "(252, '511700', '达州市', '510000'),\n" +
                "(253, '511800', '雅安市', '510000'),\n" +
                "(254, '511900', '巴中市', '510000'),\n" +
                "(255, '512000', '资阳市', '510000'),\n" +
                "(256, '513200', '阿坝藏族羌族自治州', '510000'),\n" +
                "(257, '513300', '甘孜藏族自治州', '510000'),\n" +
                "(258, '513400', '凉山彝族自治州', '510000'),\n" +
                "(259, '520100', '贵阳市', '520000'),\n" +
                "(260, '520200', '六盘水市', '520000'),\n" +
                "(261, '520300', '遵义市', '520000'),\n" +
                "(262, '520400', '安顺市', '520000'),\n" +
                "(263, '522200', '铜仁地区', '520000'),\n" +
                "(264, '522300', '黔西南布依族苗族自治州', '520000'),\n" +
                "(265, '522400', '毕节地区', '520000'),\n" +
                "(266, '522600', '黔东南苗族侗族自治州', '520000'),\n" +
                "(267, '522700', '黔南布依族苗族自治州', '520000'),\n" +
                "(268, '530100', '昆明市', '530000'),\n" +
                "(269, '530300', '曲靖市', '530000'),\n" +
                "(270, '530400', '玉溪市', '530000'),\n" +
                "(271, '530500', '保山市', '530000'),\n" +
                "(272, '530600', '昭通市', '530000'),\n" +
                "(273, '530700', '丽江市', '530000'),\n" +
                "(274, '530800', '思茅市', '530000'),\n" +
                "(275, '530900', '临沧市', '530000'),\n" +
                "(276, '532300', '楚雄彝族自治州', '530000'),\n" +
                "(277, '532500', '红河哈尼族彝族自治州', '530000'),\n" +
                "(278, '532600', '文山壮族苗族自治州', '530000'),\n" +
                "(279, '532800', '西双版纳傣族自治州', '530000'),\n" +
                "(280, '532900', '大理白族自治州', '530000'),\n" +
                "(281, '533100', '德宏傣族景颇族自治州', '530000'),\n" +
                "(282, '533300', '怒江傈僳族自治州', '530000'),\n" +
                "(283, '533400', '迪庆藏族自治州', '530000'),\n" +
                "(284, '540100', '拉萨市', '540000'),\n" +
                "(285, '542100', '昌都地区', '540000'),\n" +
                "(286, '542200', '山南地区', '540000'),\n" +
                "(287, '542300', '日喀则地区', '540000'),\n" +
                "(288, '542400', '那曲地区', '540000'),\n" +
                "(289, '542500', '阿里地区', '540000'),\n" +
                "(290, '542600', '林芝地区', '540000'),\n" +
                "(291, '610100', '西安市', '610000'),\n" +
                "(292, '610200', '铜川市', '610000'),\n" +
                "(293, '610300', '宝鸡市', '610000'),\n" +
                "(294, '610400', '咸阳市', '610000'),\n" +
                "(295, '610500', '渭南市', '610000'),\n" +
                "(296, '610600', '延安市', '610000'),\n" +
                "(297, '610700', '汉中市', '610000'),\n" +
                "(298, '610800', '榆林市', '610000'),\n" +
                "(299, '610900', '安康市', '610000'),\n" +
                "(300, '611000', '商洛市', '610000'),\n" +
                "(301, '620100', '兰州市', '620000'),\n" +
                "(302, '620200', '嘉峪关市', '620000'),\n" +
                "(303, '620300', '金昌市', '620000'),\n" +
                "(304, '620400', '白银市', '620000'),\n" +
                "(305, '620500', '天水市', '620000'),\n" +
                "(306, '620600', '武威市', '620000'),\n" +
                "(307, '620700', '张掖市', '620000'),\n" +
                "(308, '620800', '平凉市', '620000'),\n" +
                "(309, '620900', '酒泉市', '620000'),\n" +
                "(310, '621000', '庆阳市', '620000'),\n" +
                "(311, '621100', '定西市', '620000'),\n" +
                "(312, '621200', '陇南市', '620000'),\n" +
                "(313, '622900', '临夏回族自治州', '620000'),\n" +
                "(314, '623000', '甘南藏族自治州', '620000'),\n" +
                "(315, '630100', '西宁市', '630000'),\n" +
                "(316, '632100', '海东地区', '630000'),\n" +
                "(317, '632200', '海北藏族自治州', '630000'),\n" +
                "(318, '632300', '黄南藏族自治州', '630000'),\n" +
                "(319, '632500', '海南藏族自治州', '630000'),\n" +
                "(320, '632600', '果洛藏族自治州', '630000'),\n" +
                "(321, '632700', '玉树藏族自治州', '630000'),\n" +
                "(322, '632800', '海西蒙古族藏族自治州', '630000'),\n" +
                "(323, '640100', '银川市', '640000'),\n" +
                "(324, '640200', '石嘴山市', '640000'),\n" +
                "(325, '640300', '吴忠市', '640000'),\n" +
                "(326, '640400', '固原市', '640000'),\n" +
                "(327, '640500', '中卫市', '640000'),\n" +
                "(328, '650100', '乌鲁木齐市', '650000'),\n" +
                "(329, '650200', '克拉玛依市', '650000'),\n" +
                "(330, '652100', '吐鲁番地区', '650000'),\n" +
                "(331, '652200', '哈密地区', '650000'),\n" +
                "(332, '652300', '昌吉回族自治州', '650000'),\n" +
                "(333, '652700', '博尔塔拉蒙古自治州', '650000'),\n" +
                "(334, '652800', '巴音郭楞蒙古自治州', '650000'),\n" +
                "(335, '652900', '阿克苏地区', '650000'),\n" +
                "(336, '653000', '克孜勒苏柯尔克孜自治州', '650000'),\n" +
                "(337, '653100', '喀什地区', '650000'),\n" +
                "(338, '653200', '和田地区', '650000'),\n" +
                "(339, '654000', '伊犁哈萨克自治州', '650000'),\n" +
                "(340, '654200', '塔城地区', '650000'),\n" +
                "(341, '654300', '阿勒泰地区', '650000'),\n" +
                "(342, '654300', '天津市', '650000'),\n" +
                "(343, '654300', '上海市', '650000'),\n" +
                "(344, '659000', '省直辖行政单位', '650000');");
		
	}
	
	/* public boolean deleteDatabase(Context context){
		return context.deleteDatabase(DBNAME);
		 
	 }*/
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	/*public boolean deleteDatabase(Context context) {  

		return context.deleteDatabase(DBNAME);
	}*/



	public static DBOpenHelper getInstance(Context mContext) {
		// TODO Auto-generated method stub
		if (mInstance == null) {  
	          mInstance = new DBOpenHelper(mContext);  
	      }  
	      return mInstance;  
	}

  
}
