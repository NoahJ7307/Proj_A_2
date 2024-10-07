import axios from "axios"

export const API_SERVER_HOST = "http://localhost:8080"
const host = `${API_SERVER_HOST}/api/user`

export const getOne = async(uno) =>{
    const res = await axios.get(`${host}/${uno}`)
    return res.data
}

export const getList = async(pageParam) =>{
    const {page, size} = pageParam
    const res = await axios.get(`${host}/list`, {params:{page, size}})
    return res.data
}