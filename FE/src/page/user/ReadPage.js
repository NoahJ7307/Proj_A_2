import React from 'react'
import { useParams } from 'react-router-dom'

const ReadPage = () => {
    const { tno } = useParams()
    return (
        <div>ReadPage{tno}</div>
    )
}

export default ReadPage