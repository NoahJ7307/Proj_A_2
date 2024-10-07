import React, { useCallback } from 'react'
import BasicLayout from '../../layout/BasicLayout'
import { Outlet, useNavigate } from 'react-router-dom'

const IndexPage = () => {
    const navigate = useNavigate()

    const handleClickList = useCallback(() => { navigate({ pathname: 'list' }) })
    const handleClickAdd = useCallback(() => { navigate({ pathname: 'add' }) })
    return (
        <BasicLayout>
            <div className='w-full flex m-2 p-2'>
                <div className='text-xl p-2 mr-3 font-extrabold text-center cursor-pointer bg-gray-300 rounded-2xl'
                    onClick={handleClickList}>목록</div>
                <div className='text-xl p-2 mr-3 font-extrabold text-center cursor-pointer bg-gray-300 rounded-2xl'
                    onClick={handleClickAdd}>추가</div>
            </div>
            <div className='flex flex-wrap w-full'>
                <Outlet />
            </div>
        </BasicLayout>
    )
}

export default IndexPage