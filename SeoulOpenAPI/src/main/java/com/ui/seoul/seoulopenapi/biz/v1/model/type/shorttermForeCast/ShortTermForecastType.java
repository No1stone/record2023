package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast;

import com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dong.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ShortTermForecastType {

    종로구(Arrays.asList(JongnoGu.종로구, JongnoGu.청운효자동, JongnoGu.사직동, JongnoGu.삼청동, JongnoGu.부암동, JongnoGu.평창동, JongnoGu.무악동,
            JongnoGu.교남동, JongnoGu.가회동, JongnoGu.종로1가동, JongnoGu.종로2가동, JongnoGu.종로3가동, JongnoGu.종로4가동, JongnoGu.종로5가동,
            JongnoGu.종로5가동, JongnoGu.종로6가동, JongnoGu.이화동, JongnoGu.혜화동, JongnoGu.창신제1동, JongnoGu.창신제2동, JongnoGu.창신제3동,
            JongnoGu.숭인제1동, JongnoGu.숭인제2동)),

    중구(Arrays.asList(JungGu.중구, JungGu.소공동, JungGu.회현동, JungGu.명동, JungGu.필동, JungGu.장충동, JungGu.광희동, JungGu.을지로동,
            JungGu.신당동, JungGu.다산동, JungGu.약수동, JungGu.청구동, JungGu.신당제5동, JungGu.동화동, JungGu.황학동, JungGu.중림동)),

    용산구(Arrays.asList(YongsanGu.용산구, YongsanGu.후암동,
            YongsanGu.용산2가동, YongsanGu.남영동, YongsanGu.청파동, YongsanGu.원효로제1동, YongsanGu.원효로제2동, YongsanGu.효창동, YongsanGu.용문동, YongsanGu.한강로동,
            YongsanGu.이촌제1동, YongsanGu.이촌제2동, YongsanGu.이태원제1동, YongsanGu.이태원제2동, YongsanGu.한남동, YongsanGu.서빙고동, YongsanGu.보광동)),

    성동구(Arrays.asList(SeongdongGu.성동구, SeongdongGu.왕십리제2동, SeongdongGu.왕십리도선동, SeongdongGu.마장동, SeongdongGu.사근동,
            SeongdongGu.행당제1동, SeongdongGu.행당제2동, SeongdongGu.응봉동, SeongdongGu.금호1가동, SeongdongGu.금호2가동, SeongdongGu.금호3가동,
            SeongdongGu.금호4가동, SeongdongGu.옥수동, SeongdongGu.성수1가제1동, SeongdongGu.성수1가제2동, SeongdongGu.성수2가제1동,
            SeongdongGu.성수2가제3동, SeongdongGu.송정동, SeongdongGu.용답동)),

    광진구(Arrays.asList(GwangjinGu.광진구, GwangjinGu.화양동, GwangjinGu.군자동, GwangjinGu.중곡제1동, GwangjinGu.중곡제2동, GwangjinGu.중곡제3동,
            GwangjinGu.중곡제4동, GwangjinGu.능동, GwangjinGu.광장동, GwangjinGu.자양제1동, GwangjinGu.자양제2동, GwangjinGu.자양제3동,
            GwangjinGu.자양제4동, GwangjinGu.구의제1동, GwangjinGu.구의제2동, GwangjinGu.구의제3동)),

    동대문구(Arrays.asList(DongdaemunGu.동대문구, DongdaemunGu.용신동, DongdaemunGu.제기동, DongdaemunGu.전농제1동, DongdaemunGu.전농제2동,
            DongdaemunGu.답십리제1동, DongdaemunGu.답십리제2동, DongdaemunGu.장안제1동, DongdaemunGu.장안제2동, DongdaemunGu.청량리동, DongdaemunGu.회기동,
            DongdaemunGu.휘경제1동, DongdaemunGu.휘경제2동, DongdaemunGu.이문제1동)),

    중랑구(Arrays.asList(JungnangGu.중랑구, JungnangGu.면목제2동, JungnangGu.면목제4동, JungnangGu.면목제5동, JungnangGu.면목본동, JungnangGu.면목제7동,
            JungnangGu.면목제3동, JungnangGu.면목제8동, JungnangGu.상봉제1동, JungnangGu.상봉제2동, JungnangGu.중화제1동, JungnangGu.중화제2동,
            JungnangGu.묵제1동, JungnangGu.묵제2동, JungnangGu.망우본동, JungnangGu.망우제3동, JungnangGu.신내1동, JungnangGu.신내2동)),

    성북구(Arrays.asList(SeongbukGu.성북구, SeongbukGu.성북동, SeongbukGu.삼선동, SeongbukGu.동선동, SeongbukGu.돈암제1동, SeongbukGu.돈암제2동,
            SeongbukGu.안암동, SeongbukGu.보문동, SeongbukGu.정릉제1동, SeongbukGu.정릉제2동,
            SeongbukGu.정릉제3동, SeongbukGu.정릉제4동, SeongbukGu.길음제1동, SeongbukGu.길음제2동,
            SeongbukGu.종암동, SeongbukGu.월곡제1동, SeongbukGu.월곡제2동, SeongbukGu.장위제1동,
            SeongbukGu.장위제2동, SeongbukGu.장위제3동, SeongbukGu.석관동)),

    강북구(Arrays.asList(GangbukGu.강북구, GangbukGu.삼양동, GangbukGu.미아동, GangbukGu.송중동, GangbukGu.송천동, GangbukGu.삼각산동, GangbukGu.번1동,
            GangbukGu.번2동, GangbukGu.번3동, GangbukGu.수유1동, GangbukGu.수유2동, GangbukGu.수유3동, GangbukGu.우이동, GangbukGu.인수동)),

    도봉구(Arrays.asList(DobongGu.도봉구, DobongGu.창제1동, DobongGu.창제2동, DobongGu.창제3동, DobongGu.창제4동, DobongGu.창제5동, DobongGu.도봉제1동,
            DobongGu.도봉제2동, DobongGu.쌍문제1동, DobongGu.쌍문제2동, DobongGu.쌍문제3동, DobongGu.쌍문제4동, DobongGu.방학제1동, DobongGu.방학제2동, DobongGu.방학제3동)),

    노원구(Arrays.asList(NowonGu.노원구, NowonGu.월계1동, NowonGu.월계2동, NowonGu.월계3동, NowonGu.공릉1동, NowonGu.공릉2동, NowonGu.하계1동, NowonGu.하계2동,
            NowonGu.중계본동, NowonGu.중계1동, NowonGu.중계4동, NowonGu.중계2동, NowonGu.중계3동, NowonGu.상계1동, NowonGu.상계2동, NowonGu.상계3동,
            NowonGu.상계4동, NowonGu.상계5동, NowonGu.상계6동, NowonGu.상계7동, NowonGu.상계8동, NowonGu.상계9동, NowonGu.상계10동)),

    은평구(Arrays.asList(EunpyeongGu.은평구, EunpyeongGu.녹번동, EunpyeongGu.불광제1동, EunpyeongGu.불광제2동, EunpyeongGu.갈현제1동, EunpyeongGu.갈현제2동,
            EunpyeongGu.구산동, EunpyeongGu.대조동, EunpyeongGu.응암제1동, EunpyeongGu.응암제2동, EunpyeongGu.응암제3동, EunpyeongGu.역촌동,
            EunpyeongGu.신사제1동, EunpyeongGu.신사제2동, EunpyeongGu.증산동, EunpyeongGu.수색동, EunpyeongGu.진관동)),

    서대문구(Arrays.asList(SeodaemunGu.서대문구, SeodaemunGu.천연동, SeodaemunGu.북아현동, SeodaemunGu.충현동, SeodaemunGu.신촌동, SeodaemunGu.연희동,
            SeodaemunGu.홍제제1동, SeodaemunGu.홍제제3동, SeodaemunGu.홍제제2동, SeodaemunGu.홍은제1동, SeodaemunGu.홍은제2동, SeodaemunGu.남가좌제1동,
            SeodaemunGu.남가좌제2동, SeodaemunGu.북가좌제1동, SeodaemunGu.북가좌제2동)),

    마포구(Arrays.asList(MapoGu.마포구, MapoGu.아현동, MapoGu.공덕동, MapoGu.도화동, MapoGu.용강동, MapoGu.대흥동, MapoGu.염리동, MapoGu.신수동,
            MapoGu.서강동, MapoGu.서교동, MapoGu.합정동, MapoGu.망원제1동, MapoGu.망원제2동, MapoGu.연남동, MapoGu.성산제1동, MapoGu.성산제2동, MapoGu.상암동)),

    양천구(Arrays.asList(YangcheonGu.양천구, YangcheonGu.목1동, YangcheonGu.목2동, YangcheonGu.목3동, YangcheonGu.목4동, YangcheonGu.목5동, YangcheonGu.신월1동,
            YangcheonGu.신월2동, YangcheonGu.신월3동, YangcheonGu.신월4동, YangcheonGu.신월5동, YangcheonGu.신월6동, YangcheonGu.신월7동,
            YangcheonGu.신정1동, YangcheonGu.신정2동, YangcheonGu.신정3동, YangcheonGu.신정4동, YangcheonGu.신정6동, YangcheonGu.신정7동)),

    강서구(Arrays.asList(GangseoGu.강서구, GangseoGu.염창동, GangseoGu.등촌제1동, GangseoGu.등촌제2동, GangseoGu.등촌제3동, GangseoGu.화곡제1동,
            GangseoGu.화곡제2동, GangseoGu.화곡제3동, GangseoGu.화곡제4동, GangseoGu.화곡본동, GangseoGu.화곡제6동, GangseoGu.화곡제8동,
            GangseoGu.가양제1동, GangseoGu.가양제2동, GangseoGu.가양제3동, GangseoGu.발산제1동, GangseoGu.우장산동, GangseoGu.공항동,
            GangseoGu.방화제1동, GangseoGu.방화제2동, GangseoGu.방화제3동)),

    구로구(Arrays.asList(GuroGu.구로구, GuroGu.신도림동, GuroGu.구로제1동, GuroGu.구로제2동, GuroGu.구로제3동, GuroGu.구로제4동, GuroGu.구로제5동, GuroGu.가리봉동,
            GuroGu.고척제1동, GuroGu.고척제2동, GuroGu.개봉제1동, GuroGu.개봉제2동, GuroGu.개봉제3동, GuroGu.오류제1동, GuroGu.오류제2동, GuroGu.수궁동, GuroGu.항동)),

    금천구(Arrays.asList(GeumcheonGu.금천구, GeumcheonGu.가산동, GeumcheonGu.독산제1동, GeumcheonGu.독산제2동, GeumcheonGu.독산제3동, GeumcheonGu.독산제4동,
            GeumcheonGu.시흥제1동, GeumcheonGu.시흥제2동, GeumcheonGu.시흥제3동, GeumcheonGu.시흥제4동, GeumcheonGu.시흥제5동)),

    영등포구(Arrays.asList(YeongdeungpoGu.영등포구, YeongdeungpoGu.영등포본동, YeongdeungpoGu.영등포동, YeongdeungpoGu.여의동, YeongdeungpoGu.당산제1동,
            YeongdeungpoGu.당산제2동, YeongdeungpoGu.도림동, YeongdeungpoGu.문래동, YeongdeungpoGu.양평제1동, YeongdeungpoGu.양평제2동, YeongdeungpoGu.신길제1동,
            YeongdeungpoGu.신길제3동, YeongdeungpoGu.신길제4동, YeongdeungpoGu.신길제5동, YeongdeungpoGu.신길제6동, YeongdeungpoGu.신길제7동, YeongdeungpoGu.대림제1동,
            YeongdeungpoGu.대림제2동, YeongdeungpoGu.대림제3동)),

    동작구(Arrays.asList(DongjakGu.동작구, DongjakGu.노량진제1동, DongjakGu.노량진제2동, DongjakGu.상도제1동, DongjakGu.상도제2동, DongjakGu.상도제3동,
            DongjakGu.상도제4동, DongjakGu.흑석동, DongjakGu.사당제1동, DongjakGu.사당제2동, DongjakGu.사당제3동, DongjakGu.사당제4동,
            DongjakGu.사당제5동, DongjakGu.대방동, DongjakGu.신대방제1동, DongjakGu.신대방제2동)),

    관악구(Arrays.asList(GwanakGu.관악구, GwanakGu.보라매동,
            GwanakGu.청림동, GwanakGu.성현동, GwanakGu.행운동, GwanakGu.낙성대동, GwanakGu.청룡동, GwanakGu.은천동, GwanakGu.중앙동, GwanakGu.인헌동,
            GwanakGu.남현동, GwanakGu.서원동, GwanakGu.신원동, GwanakGu.서림동, GwanakGu.신사동, GwanakGu.신림동, GwanakGu.난향동, GwanakGu.조원동,
            GwanakGu.대학동, GwanakGu.삼성동, GwanakGu.미성동, GwanakGu.난곡동)),

    서초구(Arrays.asList(SeochoGu.서초구, SeochoGu.서초1동, SeochoGu.서초2동, SeochoGu.서초3동, SeochoGu.서초4동, SeochoGu.잠원동, SeochoGu.반포본동, SeochoGu.반포1동,
            SeochoGu.반포2동, SeochoGu.반포3동, SeochoGu.반포4동, SeochoGu.방배본동, SeochoGu.방배1동, SeochoGu.방배2동, SeochoGu.방배3동, SeochoGu.방배4동,
            SeochoGu.양재1동, SeochoGu.양재2동, SeochoGu.내곡동)),

    강남구(Arrays.asList(GangnamGu.강남구, GangnamGu.신사동, GangnamGu.논현1동, GangnamGu.논현2동, GangnamGu.압구정동, GangnamGu.청담동, GangnamGu.삼성1동, GangnamGu.삼성2동,
            GangnamGu.대치1동, GangnamGu.대치2동, GangnamGu.대치4동, GangnamGu.역삼1동, GangnamGu.역삼2동, GangnamGu.도곡1동, GangnamGu.도곡2동, GangnamGu.개포1동,
            GangnamGu.개포2동, GangnamGu.개포4동, GangnamGu.세곡동, GangnamGu.일원본동, GangnamGu.일원1동, GangnamGu.일원2동, GangnamGu.수서동)),

    송파구(Arrays.asList(SongpaGu.송파구, SongpaGu.풍납1동, SongpaGu.풍납2동, SongpaGu.거여1동, SongpaGu.거여2동, SongpaGu.마천1동, SongpaGu.마천2동, SongpaGu.방이1동,
            SongpaGu.방이2동, SongpaGu.오륜동, SongpaGu.오금동, SongpaGu.송파1동, SongpaGu.송파2동, SongpaGu.석촌동, SongpaGu.삼전동, SongpaGu.가락본동,
            SongpaGu.가락1동, SongpaGu.가락2동, SongpaGu.문정1동, SongpaGu.문정2동, SongpaGu.장지동, SongpaGu.위례동, SongpaGu.잠실본동, SongpaGu.잠실2동,
            SongpaGu.잠실3동, SongpaGu.잠실4동, SongpaGu.잠실6동, SongpaGu.잠실7동)),


    강동구(Arrays.asList(GangDongGu.강동구, GangDongGu.강일동, GangDongGu.상일제1동, GangDongGu.상일제2동, GangDongGu.명일제1동, GangDongGu.명일제2동, GangDongGu.고덕제1동, GangDongGu.고덕제2동,
            GangDongGu.암사제1동, GangDongGu.암사제2동, GangDongGu.암사제3동, GangDongGu.천호제1동, GangDongGu.천호제2동, GangDongGu.천호제3동, GangDongGu.성내제1동, GangDongGu.성내제2동,
            GangDongGu.성내제3동, GangDongGu.길동, GangDongGu.둔촌제1동, GangDongGu.둔촌제2동));

    private List<Object> gu;

    ShortTermForecastType(List<Object> gu) {
        this.gu = gu;
    }

    public List<Object> getGu() {
        return gu;
    }

}
