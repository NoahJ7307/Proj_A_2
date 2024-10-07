import React, { lazy, Suspense } from 'react'
import userRouter from './userRouter'

const { createBrowserRouter } = require("react-router-dom")

const Loading = <div>......</div>
const Main = lazy(() => import("../page/MainPage"))
const User = lazy(() => import("../page/user/IndexPage"))


const root = createBrowserRouter([
    {
        path: "",
        element: <Suspense fallback={Loading}><Main /></Suspense>
    },
    {
        path: "user",
        element: <Suspense fallback={Loading}><User /></Suspense>,
        children: userRouter()
    },
])

export default root