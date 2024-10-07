import React from 'react'
import { Link } from 'react-router-dom'

const BasicMenu = () => {

  return (
    <nav id='navbar' className='flex'>
      <div className='w-full bg-black'>
        <ul className='flex p-4 text-white font-bold'>
          <li className='pr-6 text-2xl'><Link to={'/'}>홈</Link></li>
          <li className='pr-6 text-2xl'><Link to={'/user'}>입주민관리</Link></li>
        </ul>
      </div>
    </nav>
  )
}

export default BasicMenu