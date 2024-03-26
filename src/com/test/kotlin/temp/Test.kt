package com.test.kotlin.temp

import java.net.URLDecoder

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
//        String str = "";
//        System.out.println(StringUtils.Companion.isEmpty(str));
//        int i = 10;
//        while (i-- > 0) {
//            System.out.println(i);
//        }
//
//        UtilsKt.echo("utils.");
//        UtilsKt.echo("");
//        UtilsKt.echo(null); // 报错
        val s1 =
            "https://m.sogou.com/openapi/h5/gaokao/school/list.html?listType=fenshu&from=vr_fenshuxuandaxue&province=%E5%8C%97%E4%BA%AC&score=500&major=%E7%90%86%E7%A7%91"
        println(getValueByNameFromUrl(s1, "major"))
        val s2 =
            "https://m.sogou.com/web/searchList.jsp?uID=AAEqk8tyLwAAAAqPLE8ggAEAZAM%3D&v=5&dp=1&pid=sogou-waps-7880d7226e872b77&w=1283&t=1592295008325&s_t=1592295269661&s_from=result_up&htprequery=500%E5%88%86%E4%B8%8A%E4%BB%80%E4%B9%88%E5%A4%A7%E5%AD%A6&keyword=%E5%8F%8C%E4%B8%80%E6%B5%81%E5%A4%A7%E5%AD%A6&pg=webSearchList&rcer=hNz_aRIBWIwCGa7H&s=%E6%90%9C%E7%B4%A2&suguuid=67c18182-d9cc-4b3d-888c-24d2945c54a1&sugsuv=AAEqk8tyLwAAAAqPLE8ggAEAZAM&sugtime=1592295269661"
        println(getValueByNameFromUrl(s2, "keyword"))
        val s3 =
            "https://m.sogou.com/web/searchList.jsp?uID=AAEqk8tyLwAAAAqPLE8ggAEAZAM%3D&v=5&dp=1&pid=sogou-waps-7880d7226e872b77&w=1283&t=1592295269605&s_t=1592295281678&s_from=result_up&htprequery=%E5%8F%8C%E4%B8%80%E6%B5%81%E5%A4%A7%E5%AD%A6&keyword=%E9%87%91%E8%9E%8D%E5%AD%A6%E4%B8%93%E4%B8%9A&pg=webSearchList&rcer=hNz_aRIBWIwCGa7H&s=%E6%90%9C%E7%B4%A2&suguuid=324a8866-6dd8-4eb1-9559-c94403364e37&sugsuv=AAEqk8tyLwAAAAqPLE8ggAEAZAM&sugtime=1592295281678"
        println(getValueByNameFromUrl(s3, "keyword"))
        val s4 =
            "http://10.153.62.190/openapi/h5/university/home?school=%E6%B5%99%E6%B1%9F%E5%A4%A7%E5%AD%A6&province=%E5%8C%97%E4%BA%AC"
        println(getValueByNameFromUrl(s4, "school"))
        val s5 = "http://10.153.62.190/openapi/h5/university/home?school=浙江大学"
        println(getValueByNameFromUrl(s5, "school"))
    }

    private fun getValueByNameFromUrl(url: String, name: String): String {
        return try {
            var result = ""
            val index = url.indexOf("?") // 字符串中第一个 '?' 开始index
            val temp = url.substring(index + 1)
            val keyValue = temp.split("&".toRegex()).toTypedArray()
            for (str in keyValue) {
                if (str.contains(name)) {
                    val valueStartIndex = str.indexOf(name) // name值起始index
                    val nameLen = name.length // name值字符串长度
                    val subIndex = valueStartIndex + nameLen + 1
                    result = str.substring(subIndex)
                    break
                }
            }
            URLDecoder.decode(result)
        } catch (e: Exception) {
            ""
        }
    }
}