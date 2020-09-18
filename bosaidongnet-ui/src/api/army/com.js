import request from '@/utils/request'

// 查询公司列表
export function listCom(query) {
  return request({
    url: '/army/com/list',
    method: 'get',
    params: query
  })
}

// 查询公司详细
export function getCom(comId) {
  return request({
    url: '/army/com/' + comId,
    method: 'get'
  })
}

// 新增公司
export function addCom(data) {
  return request({
    url: '/army/com',
    method: 'post',
    data: data
  })
}

// 修改公司
export function updateCom(data) {
  return request({
    url: '/army/com',
    method: 'put',
    data: data
  })
}

// 删除公司
export function delCom(comId) {
  return request({
    url: '/army/com/' + comId,
    method: 'delete'
  })
}

// 导出公司
export function exportCom(query) {
  return request({
    url: '/army/com/export',
    method: 'get',
    params: query
  })
}