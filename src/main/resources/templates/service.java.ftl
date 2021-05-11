package ${package.Service};

import com.baomidou.mybatisplus.extension.service.IService;
import ${package.Entity}.${entity};

/**
 * @author ${author}
 * @date ${datetime}
 * @description
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends IService<${entity}> {

}
</#if>
