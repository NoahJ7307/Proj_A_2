import React, { lazy, Suspense } from 'react'
import { Navigate } from 'react-router-dom'

const userRouter = () => {

    const Loading = <div>......</div>
    const UserList = lazy(() => import("../page/user/ListPage"))
    const UserAdd = lazy(() => import("../page/user/AddPage"))
    const UserRead = lazy(() => import("../page/user/ReadPage"))

    return [
        {
            path: "",
            element: <Navigate replace to="/user/list" />
        },
        {
            path: "list",
            element: <Suspense fallback={Loading}><UserList /></Suspense>
        },
        {
            path: "add",
            element: <Suspense fallback={Loading}><UserAdd /></Suspense>
        },
        {
            path: "read/:tno",
            element: <Suspense fallback={Loading}><UserRead /></Suspense>
        },
    ]
}

export default userRouter