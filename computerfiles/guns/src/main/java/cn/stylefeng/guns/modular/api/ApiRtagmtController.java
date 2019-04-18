package cn.stylefeng.guns.modular.api;


import cn.stylefeng.guns.core.util.IDCreateUtil;
import cn.stylefeng.guns.modular.ckrelation.service.ICkrelationService;
import cn.stylefeng.guns.modular.rtagmt.service.IReportAgritainmentService;
import cn.stylefeng.guns.modular.system.model.Ckrelation;
import cn.stylefeng.guns.modular.system.model.QyChinfo;
import cn.stylefeng.guns.modular.system.model.ReportAgritainment;
import cn.stylefeng.guns.modular.system.transfer.ReportAgritainmentDto;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 农家乐报备api控制器
 *
 * @author zmq
 * @Date 2019-02-06 11:18:24
 */
@RestController
@RequestMapping("/rtagmtApi")
public class ApiRtagmtController<all_qy_chinfo> extends BaseController {


    @Autowired
    private IReportAgritainmentService reportAgritainmentService;
    @Autowired
    private ICkrelationService ckrelationService;

    /**
     * 新增报备
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ReportAgritainmentDto reportAgritainment) {

            ResponseData responseData = new ResponseData();//新建返回数据对象
            String id = IDCreateUtil.genUniqueKey();
            reportAgritainment.setId(id);
            String qyChinfo =  reportAgritainment.getAllQyChinfo();
            ArrayList<QyChinfo> chinfos = JSON.parseObject(qyChinfo, new TypeReference<ArrayList<QyChinfo>>() {});
            for (int i=0;i<chinfos.size();i++){
                Ckrelation ckrelation = new Ckrelation();
                BeanUtils.copyProperties(chinfos.get(i),ckrelation);
                ckrelation.setId(IDCreateUtil.genUniqueKey());
                ckrelation.setRelationrpid(id);
                ckrelationService.insert(ckrelation);
            }
            ReportAgritainment reportAgritainment1 = new ReportAgritainment();
            BeanUtils.copyProperties(reportAgritainment,reportAgritainment1);
            boolean state = reportAgritainmentService.insert(reportAgritainment1);
            if (state){
                responseData.setMessage("报备信息已提交，待审核");
                responseData.setCode(200);
                responseData.setSuccess(true);
                return responseData;
            }else{
                responseData.setMessage("报备信息提交失败");
                responseData.setCode(400);
                responseData.setSuccess(false);
                return responseData;
            }
        }
    /**
     * 查询帮厨列表信息
     */
    @RequestMapping(value = "/list")
    public Object query(@RequestParam("account") String account) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap<>();
        map.put("useraccount",account);
        List<ReportAgritainment> reportAgritainments = reportAgritainmentService.selectByMap(map);
        responseData.setMessage("请求成功");
        responseData.setCode(200);
        responseData.setSuccess(true);
        responseData.setData(reportAgritainments);
        return responseData;
    }
    /**
     * 查询帮厨列表信息
     */
    @RequestMapping(value = "/details")
    public Object details(@RequestParam("id") String id) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap<>();
        map.put("id",id);
        List<ReportAgritainment> reportAgritainments = reportAgritainmentService.selectByMap(map);
        if (reportAgritainments==null||reportAgritainments.size()==0){
            responseData.setMessage("失败");
            responseData.setCode(400);
            responseData.setSuccess(false);
            return responseData;
        }else{
            responseData.setMessage("请求成功");
            responseData.setCode(200);
            responseData.setSuccess(true);
            responseData.setData(reportAgritainments.get(0));
            return responseData;
        }
    }
}
