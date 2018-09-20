package msb.wxgzh.service;

import msb.wxgzh.pojo.FreePlanning;

public interface FreePlanningService {
    /**
     * 免费策划信息保存接口
     * @param freePlanning
     * @return
     */
    Integer insertFreePlanning(FreePlanning freePlanning);
}
