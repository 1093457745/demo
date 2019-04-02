/**
 * 班级Api
 */
import request from '@/utils/request'

export default {
  queryData(queryParam,pageParam) {
    return request(
      {
        url:'/class/query',
        method: 'post',
        data: {
          ...queryParam,
          current: pageParam.current,
          size: pageParam.size
        }
      })
  }
}
